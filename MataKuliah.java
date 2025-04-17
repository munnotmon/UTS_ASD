class MataKuliah {
    String kodeMK;
    String namaMK;
    int sks;

    public MataKuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    public void tampilMataKuliah() {
        System.out.println("Kode MK: " + kodeMK + " | Nama MK: " + namaMK + " | SKS: " + sks);
    }
}