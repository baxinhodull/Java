/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto_awt;

/**
 *
 * @author Antonio
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Projeto_awt extends Frame implements ActionListener {

   private final Label nomeLabel = new Label("Nome:");
   private final Label idadeLabel = new Label("Idade:");
   private final TextField nomeField = new TextField(20);
   private final TextField idadeField = new TextField(20);
   private final Button createButton = new Button("Criar");
   private final Button readButton = new Button("Ler");
   private final Button updateButton = new Button("Atualizar");
   private final Button deleteButton = new Button("Apagar");
   private final TextArea outputArea = new TextArea(10, 40);
   private final ArrayList<String> nomes = new ArrayList<>();
   private final ArrayList<Integer> idades = new ArrayList<>();
   private final Button sairButton = new Button("Sair");

   public Projeto_awt() {
      super("Exemplo CRUD");
      setLayout(new FlowLayout());

      add(nomeLabel);
      add(nomeField);
      add(idadeLabel);
      add(idadeField);
      add(createButton);
      add(readButton);
      add(updateButton);
      add(deleteButton);
      add(outputArea);
      add(sairButton);

      createButton.addActionListener(this);
      readButton.addActionListener(this);
      updateButton.addActionListener(this);
      deleteButton.addActionListener(this);
      sairButton.addActionListener(this);

      setSize(500, 300);
      setVisible(true);
   }

    /**
     *
     * @param e
     */
    @Override
   public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
        case "Criar" -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            nomes.add(nome);
            idades.add(idade);
            outputArea.setText("Dados Criados: " + nome + " (" + idade + ")");
            nomeField.setText("");
            idadeField.setText("");
           }
        case "Ler" -> {
            outputArea.setText("");
            for (int i = 0; i < nomes.size(); i++) {
                String nome = nomes.get(i);
                int idade = idades.get(i);
                outputArea.append(nome + " (" + idade + ")\n");
            }
        }
        case "Atualizar" -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            int index = nomes.indexOf(nome);
            if (index != -1) {
                idades.set(index, idade);
                outputArea.setText("Registro atualizado: " + nome + " (" + idade + ")");
            } else {
                outputArea.setText("Registro não encontrado: " + nome);
            }
            nomeField.setText("");
            idadeField.setText("");
           }
        case "Apagar" -> {
               String nome = nomeField.getText();
            int index = nomes.indexOf(nome);
            if (index != -1) {
               nomes.remove(index);
               idades.remove(index);
               outputArea.setText("Registro Apagado: " + nome);
            } else {
               outputArea.setText("Registro não encontrado: " + nome);
            }
            nomeField.setText("");
            idadeField.setText("");
           }
        case "Sair" -> {
            dispose();
        }
        default -> outputArea.setText("Opção invalida.");
    }
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Projeto_awt();
    }
    
}
