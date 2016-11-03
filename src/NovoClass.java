
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class NovoClass {

    public static void main(String[] args) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.addValue(40.5, "Azul", "dia 1");
        ds.addValue(18.2, "Azul", "dia 2");
        ds.addValue(37.3, "Azul", "dia 3");
        ds.addValue(21.5, "Azul", "dia 4");
        ds.addValue(35.7, "Azul", "dia 5");
        ds.addValue(48.5, "Azul", "dia 6");
        ds.addValue(38.2, "Amarelo", "dia 1");
        ds.addValue(37.3, "Amarelo", "dia 2");
        ds.addValue(31.5, "Amarelo", "dia 3");
        ds.addValue(35.7, "Amarelo", "dia 4");
        ds.addValue(42.5, "Amarelo", "dia 5");
        ds.addValue(46.5, "Amarelo", "dia 6");

// cria o gráfico
        //JFrame jf = new JFrame();
        JFreeChart grafico = ChartFactory.createLineChart("Teste de Gráfico","Dias","Valores", ds, PlotOrientation.VERTICAL, true, true,false );
        CategoryItemRenderer renderer = grafico.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint( 0, Color.BLUE );
        renderer.setSeriesPaint( 1, Color.YELLOW );
        ChartPanel panel = new ChartPanel( grafico );
//        jf.add( panel, BorderLayout.CENTER );
//        jf.setVisible( true );
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
