package Day4_1;

import joinery.DataFrame;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass6 {
    public static void main(String[] args){
        //joinery
        try {
            DataFrame<Object> df =DataFrame.readCsv("titanic.csv");
            System.out.println(df.describe());
            System.out.println( MainClass6.addColumn(df).describe());
            System.out.println(df.select(objects -> {
                return objects.get(0).equals(Long.parseLong("1"));

            }).describe());
            System.out.println(df.retain(0));
            DataFrame newdf=df.retain("pclass","survived","age","joinedColumn");
            DataFrame newdf2=df.retain("parch","fare","body","joinedColumn");
            System.out.println(newdf.joinOn(newdf2,"joinedColumn").describe());


        } catch (IOException e) {
            e.printStackTrace();
        }

        //tablesaw
        try {
            Table tb=Table.read().csv("titanic.csv");
            System.out.println("Table saw example");
            System.out.println(tb.structure());
            tb=MainClass6.addColumn1(tb);

            Table tb1=tb.select("pclass","survived","age","AddedCol");
            Table tb2=tb.select("parch","fare","body","AddedCol");
            Table addedtb =tb1.joinOn("AddedCol").inner(tb2);
            System.out.println(addedtb);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public  static  DataFrame addColumn(DataFrame df){
        List<Integer> newcolval = new ArrayList<>();
        for (int i=0;i<df.length();i++){
            newcolval.add(i+1);


        }
        return df.add("joinedColumn",newcolval);

    }

    public  static  Table addColumn1(Table df){
        Integer[] values =new Integer[df.rowCount()];
        for (int i=0;i<df.rowCount();i++){
            values[i]=i+1;


        }
        IntColumn column=IntColumn.create("AddedCol",values);
        return df.addColumns(column);

    }


}
