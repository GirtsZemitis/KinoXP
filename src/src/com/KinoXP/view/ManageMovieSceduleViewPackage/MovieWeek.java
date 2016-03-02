package ManageMovieSceduleViewPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by krystian on 2016-02-25.
 */
public class MovieWeek {

    ObservableList<Time> observableList;

    public MovieWeek(){
        observableList  = FXCollections.observableArrayList();
        observableList.add(new Time("9:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("9:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("10:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("10:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("11:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("11:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("12:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("12:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("13:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("13:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("14:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("14:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("15:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("15:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("16:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("16:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("17:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("17:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("18:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("18:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("19:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("19:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("20:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("20:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("21:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("21:30","no","no","no","no","no","no","no"));
        observableList.add(new Time("22:00","no","no","no","no","no","no","no"));
        observableList.add(new Time("22:30","no","no","no","no","no","no","no"));
    }

    public ObservableList<Time> getObservableList(){
        return observableList;
    }
    public void setYes(Time time, int i){
        observableList.set(i,time);

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
