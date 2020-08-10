/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ii;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class Grafico extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Estatisticas del Covid-19 en Costa Rica");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Estatisticas del Covid-19 en Costa Rica");
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Acumulados");
       
        int iterador = 0;
        
        ProyectoII datos = new ProyectoII();
        
        for(int i = 1; i < 13; i++ ){
            
            for(int j = 1; j < 29; j++ ){
                 
                 series1.getData().add(new XYChart.Data(" ",datos.GetInfectados(j,i)));
                 j = j+2;
                 iterador++;
                
                 if(iterador >= 50){
                     break;    
                    }      
                }    
            }
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Activos");
        
        int iterador2 = 0;
        
        for(int i = 1; i < 13; i++ ){
            
            for(int j = 1; j < 29; j++ ){
                 
                 series1.getData().add(new XYChart.Data(" ",datos.GetActivos(j,i)));
                 j = j+2;
                 iterador2++;
                
                 if(iterador2 >= 50){
                     break;    
                    }      
                }    
            }
        
     

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Recuperados");
        
        int iterador3 = 0;
        
        for(int i = 1; i < 13; i++ ){
            
            for(int j = 1; j < 29; j++ ){
                 
                 series1.getData().add(new XYChart.Data(" ",datos.GetRecup(j,i)));
                 j = j+2;
                 iterador3++;
                
                 if(iterador3 >= 50){
                     break;    
                    }      
                }    
            }
     
        
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().addAll(series1, series2, series3);
       
        stage.setScene(scene);
        stage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}