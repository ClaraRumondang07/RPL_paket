package pojos;
// Generated 28-Nov-2018 10:40:36 by Hibernate Tools 4.3.1



/**
 * TambahKantor generated by hbm2java
 */
public class TambahKantor  implements java.io.Serializable {


     private String idKantor;
     private String jenis;
     private String posisi;

    public TambahKantor() {
    }

	
    public TambahKantor(String idKantor) {
        this.idKantor = idKantor;
    }
    public TambahKantor(String idKantor, String jenis, String posisi) {
       this.idKantor = idKantor;
       this.jenis = jenis;
       this.posisi = posisi;
    }
   
    public String getIdKantor() {
        return this.idKantor;
    }
    
    public void setIdKantor(String idKantor) {
        this.idKantor = idKantor;
    }
    public String getJenis() {
        return this.jenis;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public String getPosisi() {
        return this.posisi;
    }
    
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }




}


