import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SistemaInfo {

    public static void main(String[] args) {
        // Obtendo a data e hora do sistema
        Date agora = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataHora = formatoData.format(agora);

        // Obtendo o idioma do sistema
        Locale idioma = Locale.getDefault();
        String idiomaSistema = idioma.getDisplayLanguage();

        // Obtendo a resolução do monitor
        Dimension resolucao = Toolkit.getDefaultToolkit().getScreenSize();
        String resolucaoMonitor = resolucao.width + " x " + resolucao.height;

        // Exibindo as informações
        System.out.println("Data e Hora do Sistema: " + dataHora);
        System.out.println("Idioma do Sistema: " + idiomaSistema);
        System.out.println("Resolução do Monitor: " + resolucaoMonitor);
    }
}
