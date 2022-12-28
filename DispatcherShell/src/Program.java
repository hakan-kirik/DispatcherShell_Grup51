// Başlık:		Program
// Açıklama:	Programın ana sınıfı
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public class Program {

	public static void main(String[] args) {
		IProcessReader processReader = new ProcessReader(args[0]);
		IProcessor processor = new Processor();
		IDispatcher dispatcher = new Dispatcher(processor, processReader);

		dispatcher.start();
	}
}
