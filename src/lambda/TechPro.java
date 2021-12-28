package lambda;

public class TechPro {
  private  String batch;
  private  String batchName;
  private  int batchOrt;
  private  int OgrcSayisi;

    public TechPro() {
    }

    public TechPro(String batch, String batchName, int batchOrt, int ogrcSayisi) {
        this.batch = batch;
        this.batchName = batchName;
        this.batchOrt = batchOrt;
        OgrcSayisi = ogrcSayisi;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public int getBatchOrt() {
        return batchOrt;
    }

    public void setBatchOrt(int batchOrt) {
        this.batchOrt = batchOrt;
    }

    public int getOgrcSayisi() {
        return OgrcSayisi;
    }

    public void setOgrcSayisi(int ogrcSayisi) {
        OgrcSayisi = ogrcSayisi;
    }

    @Override
    public String toString() {
        return "TechPro{" +
                "batch='" + batch + '\'' +
                ", batchName='" + batchName + '\'' +
                ", batchOrt=" + batchOrt +
                ", OgrcSayisi=" + OgrcSayisi +
                '}';
    }
}
