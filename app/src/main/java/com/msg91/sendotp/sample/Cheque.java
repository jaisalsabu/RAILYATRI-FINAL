package com.msg91.sendotp.sample;

public class Cheque {

    private String Trainno;
    private String Trainname;
    private String Trainsource;
    private String Traindestination;
    private String Traindate;
    private String Traincost;



    public Cheque(String Tno,String Tname,String Tsource,String Tdest,String Tdate,String Tcost) {

        this.Trainno = Tno;
        this.Trainname = Tname;
        this.Trainsource= Tsource;
        this.Traindestination= Tdest;
        this.Traindate=Tdate;
        this.Traincost=Tcost;

    }

    public Cheque() {
    }


    public String getTrainno() {
        return Trainno;
    }
    public String getTrainname() {
        return Trainname;
    }
    public String getTrainsource() {
        return Trainsource;
    }
    public String getTraindestination() { return  Traindestination; }
    public String getTraindate() { return  Traindate; }
    public String getTraincost(){return Traincost;}}
