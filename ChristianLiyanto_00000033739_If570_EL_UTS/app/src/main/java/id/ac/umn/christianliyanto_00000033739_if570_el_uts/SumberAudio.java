package id.ac.umn.christianliyanto_00000033739_if570_el_uts;

import java.io.Serializable;

public class SumberAudio implements Serializable {
    private String judul;
    private String keterangan;
    private String videoURI;
    public SumberAudio(String judul, String keterangan,
                       String videoURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.videoURI = videoURI;
    }
    public String getJudul() { return this.judul; }
    public String getKeterangan() { return this.keterangan; }
    public String getVideoURI() { return this.videoURI; }
    public void setJudul(String judul){ this.judul = judul; }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setVideoURI(String videoURI) {
        this.videoURI = videoURI;
    }

    public String toString() {
        return this.getJudul() + " => " + this.getKeterangan();
    }
}
