package fr.sywoo.api.jump;

public class Jump {

    private int sec;

    public Jump(int sec) {
        this.sec = sec;
    }

    public int getSec() {
        //if(sec == null) sec = -1;
        return sec;
    }

    public Jump setSec(int sec) {
        this.sec = sec;
        return this;
    }
}
