// Başlık:		ISpecialProcess
// Açıklama:	SpecialProcess sınıfının arayüzü
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public interface ISpecialProcess {

	ProcessBuilder getProcessBuilder();

	int getPid();

	int getDestinationTime();

	Priority getPriority();

	// Prosesin önceliğini bir derece düşürür.
	void decreasePriority();

	int getBurstTime();

	// Prosesin çalışma süresini bir azaltır.
	void decreaseBurstTime();

	// Prosesin bekleme süresini bir artırır. Eğer 20 olmuşsa true döndürür.
	boolean increaseWaitingTime();

	// Prosesin bekleme süresini sıfırlar.
	void resetWaitingTime();

	Statement getStatement();

	void setStatement(Statement statement);
}
