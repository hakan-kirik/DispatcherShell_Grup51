// Başlık:		ProcessReader
// Açıklama:	Metin dosyasını okuyup proses oluşturan sınıf
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessReader implements IProcessReader {
	private IProcessQueue processes;

	public ProcessReader(String path) {
		this.processes = new ProcessQueue();
		readFile(path);
	}

	// Metin dosyasını okur ve bütün prosesleri oluşturup bir kuyruğa atar.
	private void readFile(String path) {
		try {
			File file = new File(path);
			if (file.exists()) {
				Scanner dosya = new Scanner(file);
				int count = 0;
				while (dosya.hasNextLine()) {
					String line = dosya.nextLine();
					line = line.replaceAll("\\s+", "");
					var processInformations = line.split(",");

					int pid = count;
					int destinationTime = Integer.parseInt(processInformations[0]);

					Priority priority = switch (Integer.parseInt(processInformations[1])) {
					case 0 -> Priority.RealTime;
					case 1 -> Priority.Highest;
					case 2 -> Priority.Medium;
					case 3 -> Priority.Lowest;
					default -> throw new IllegalArgumentException(
							"Unexpected value: " + Integer.parseInt(processInformations[1]));
					};

					int burstTime = Integer.parseInt(processInformations[2]);

					ISpecialProcess process = new SpecialProcess(pid, destinationTime, priority, burstTime);
					this.processes.enqueue(process);
					++count;
				}
				dosya.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Verilen varış zamanında gelen prosesleri döndürür. Ayrıca prosesleri içindeki
	// kuyruktan çıkarır.
	@Override
	public IProcessQueue getProcesses(int destinationTime) {
		IProcessQueue foundedProcesses = new ProcessQueue();
		IProcessQueue tmpQueue = this.processes.search(destinationTime);
		ISpecialProcess tmpProcess;
		while (!tmpQueue.isEmpty()) {
			tmpProcess = tmpQueue.dequeue();
			this.processes.delete(tmpProcess);
			foundedProcesses.enqueue(tmpProcess);
		}
		return foundedProcesses;
	}

	@Override
	public boolean isEmpty() {
		return processes.isEmpty();
	}

}
