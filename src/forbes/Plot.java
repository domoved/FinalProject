package forbes;

import java.awt.Color;
import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class Plot extends JFrame {
    public Plot(Map<String, Float> amounts) {
        Plotting(amounts);
    }

    private CategoryDataset createDataset(Map<String, Float> capitals) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        capitals.forEach((country, capital) -> ds.setValue(capital, "country", country));
        return ds;
    }

    private JFreeChart createChart(CategoryDataset ds) {
        return ChartFactory.createBarChart(
                "Общий капитал участников Forbes по странам",
                "Страна",
                "Капитал страны",
                ds,
                PlotOrientation.HORIZONTAL,
                false, true, true);
    }
    private void Plotting(Map<String, Float> capital) {
        CategoryDataset dataset = createDataset(capital);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        pack();
    }
}