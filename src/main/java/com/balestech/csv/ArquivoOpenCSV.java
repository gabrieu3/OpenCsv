package com.balestech.csv;

import com.opencsv.bean.CsvBindByPosition;

public class ArquivoOpenCSV {

    public static class Header implements Line{
        @CsvBindByPosition(position = 0)
        private String h1 = "h1";
        @CsvBindByPosition(position = 1)
        private String h2 = "h2";
        @CsvBindByPosition(position = 2)
        private String h3 = "h3";
    }

    public static class Detail implements Line{
        @CsvBindByPosition(position = 0)
        private String d1 = "d1";
        @CsvBindByPosition(position = 1)
        private String d2 = "d2";
        @CsvBindByPosition(position = 2)
        private String d3 = "d3";
        @CsvBindByPosition(position = 3)
        private String d4 = "d4";
        @CsvBindByPosition(position = 4)
        private String d5 = "d5";
        @CsvBindByPosition(position = 5)
        private String d6 = "d6";
        @CsvBindByPosition(position = 6)
        private String d7 = "d7";
    }

    public static class Footer implements Line{

        @CsvBindByPosition(position = 0)
        private String f1 = "f1";
        @CsvBindByPosition(position = 1)
        private String f2 = "f2";
    }

    public interface Line{

    }
}
