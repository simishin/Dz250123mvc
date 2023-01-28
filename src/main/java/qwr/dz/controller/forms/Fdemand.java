package qwr.dz.controller.forms;

import qwr.dz.entity.Demand;

public class Fdemand {
    private Double sideFirst;
    private Double sideSecond; //требование
    private Double corner;
    private String measure;

    public Fdemand(Double sideFirst, Double sideSecond, Double corner, String measure) {
        this.sideFirst = sideFirst;
        this.sideSecond = sideSecond;
        this.corner = corner;
        this.measure = measure;
    }
    public Fdemand() { }

    public Demand Demand(){
        return new Demand(this.sideFirst, this.sideSecond, this.corner, this.measure);
    }
    public Double getSideFirst() { return sideFirst; }
    public void setSideFirst(Double sideFirst) { this.sideFirst = sideFirst; }
    public Double getSideSecond() { return sideSecond; }
    public void setSideSecond(Double sideSecond) { this.sideSecond = sideSecond; }
    public Double getCorner() { return corner; }
    public void setCorner(Double corner) { this.corner = corner; }
    public String getMeasure() { return measure; }
    public void setMeasure(String measure) { this.measure = measure; }
}//class Fdemand
