// Başlık:		IProcessor
// Açıklama:	Processor sınıfının arayüzü
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public interface IProcessor {
	// Gönderilen prosesi çalıştırır.
	void run(ISpecialProcess process, int currentTime);
}
