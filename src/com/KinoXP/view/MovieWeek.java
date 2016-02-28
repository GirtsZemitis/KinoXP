package com.KinoXP.view;

import com.KinoXP.model.TimeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by krystian on 2016-02-25.
 */
public class MovieWeek {

    ObservableList<TimeModel> observableList;

    public MovieWeek(){
        observableList  = FXCollections.observableArrayList();
        observableList.add(new TimeModel("9:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("9:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("10:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("10:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("11:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("11:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("12:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("12:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("13:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("13:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("14:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("14:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("15:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("15:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("16:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("16:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("17:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("17:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("18:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("18:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("19:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("19:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("20:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("20:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("21:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("21:30","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("22:00","no","no","no","no","no","no","no"));
        observableList.add(new TimeModel("22:30","no","no","no","no","no","no","no"));
    }

    public ObservableList<TimeModel> getObservableList(){
        return observableList;
    }
    public void setYes(TimeModel timeModel, int i){
        observableList.set(i, timeModel);

    }
    public void printOut(){
        System.out.println("week 1");
        for(int i= 0; i<observableList.size(); i++){
            if(observableList.get(i).getMonday().equals("yes")){
                System.out.println( "monday " +  observableList.get(i).getTime());
            }
            if(observableList.get(i).getTuesday().equals("yes")){
                System.out.println( "tuesday " +  observableList.get(i).getTime());

            }
            if(observableList.get(i).getWednesday().equals("yes")){
                System.out.println( "wednesday " +  observableList.get(i).getTime());

            }
            if(observableList.get(i).getThrusday().equals("yes")){
                System.out.println( "thursday " +  observableList.get(i).getTime());

            }
            if(observableList.get(i).getFriday().equals("yes")){
                System.out.println( "friday " +  observableList.get(i).getTime());

            }
            if(observableList.get(i).getSaturday().equals("yes")){
                System.out.println( "saturday " +  observableList.get(i).getTime());

            }
            if(observableList.get(i).getSunday().equals("yes")){
                System.out.println( "sunday " +  observableList.get(i).getTime());

            }
        }
    }

}
