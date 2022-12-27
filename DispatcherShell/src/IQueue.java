// Başlık:		IQueue
// Açıklama:	Queue sınıfının arayüzü
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public interface IQueue<A> {
	void enqueue(A data);

	A dequeue();

	boolean isEmpty();
}
