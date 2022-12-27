// Başlık:		Node
// Açıklama:	Kuyruk yapısının kullandığı düğüm sınıfı
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public class Node<A> {
	public Node<A> next;
	public Node<A> prev;
	public A data;

	public Node(A data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
