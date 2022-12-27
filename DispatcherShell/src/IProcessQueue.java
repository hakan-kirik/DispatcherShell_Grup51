// Başlık:		IProcessQueue
// Açıklama:	ProcessQueue sınıfının arayüzü
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public interface IProcessQueue extends IQueue<ISpecialProcess> {

	ISpecialProcess getFirstItem();

	// Kuyruktaki tüm proseslerin bekleme zamanını 1 artırır. Bekleme süresi 20
	// saniyeyi aşan prosesleri döndürür.
	IProcessQueue increaseWaitingTime();

	IProcessQueue search(int destinationTime);

	void delete(ISpecialProcess process);
}
