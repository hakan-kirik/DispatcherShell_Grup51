// Başlık:		Statement
// Açıklama:	Proseslerin durumlarını gösteren enum yapısı
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public enum Statement {
	New, // Prosesin oluştuğu durumu
	Ready, // Prosesin hazır olduğu durum
	Running, // Proses çalıştığı durum
	Terminated, // Prosesin sonlandırıldığı durum
	TimeOut; // Prosesin zamanaşımına uğradığı durum
}
