
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class NovoClass {

    public static void main(String[] args) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(40.5, "maximo", "dia 1");
        ds.addValue(38.2, "maximo", "dia 2");
        ds.addValue(37.3, "maximo", "dia 3");
        ds.addValue(31.5, "maximo", "dia 4");
        ds.addValue(35.7, "maximo", "dia 5");
        ds.addValue(42.5, "maximo", "dia 6");

// cria o gráfico
        JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia",
                "Valor", ds, PlotOrientation.VERTICAL, true, true, false);

        OutputStream arquivo;
        try {
            arquivo = new FileOutputStream("grafico.png");

            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
            arquivo.close();
        } catch (Exception ex) {
            Logger.getLogger(NovoClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
