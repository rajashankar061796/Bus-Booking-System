package BusReservation;

public class Bus {
    private int busNo;
    private int capacity;
    private Boolean ac;
    Bus(int no,int cap,Boolean ac){
        busNo= no;
        capacity= cap;
        this.ac= ac;
    }
    public int getBusNo(){
        return busNo;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int cap){
        this.capacity= cap;
    }
    public boolean getAc(){
        return ac;
    }
    public void setAc(Boolean ac){
        this.ac= ac;
    }

}
