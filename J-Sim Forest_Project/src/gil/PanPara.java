package gil;

import gil.action.ValidParam;
import java.awt.*;
import javax.swing.*;

public class PanPara extends JPanel{
    
    private MainFrame mainframe;
    
    private JPanel radioPanel;
    
    private JButton butGeneration;
    private JButton butNext;
    private JButton butValid;
    
    private JLabel tfTailleX;
    private JLabel tfTailleY;
    private JLabel tfStep;
    
    private JTextField tailleX;
    private JTextField tailleY;
    private JTextField tfStepNumber;
    
    private ButtonGroup caseGroup;
    
    private JRadioButton emptyCaserButton;
    private JRadioButton jeunePousseCaserButton;
    private JRadioButton arbustreCaserButton;
    private JRadioButton arbreCaserButton;
    private JRadioButton feuCaserButton;
    private JRadioButton cendreCaserButton;
    private JRadioButton insecteCaserButton;
    
    public PanPara() {
        this.setPreferredSize(new Dimension(250, 150));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipady = gbc.ipadx = 0; 
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        JLabel title = new JLabel("Paramètres :");
        this.add(title ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tfTailleX = new JLabel("taille en abscisse :");
        this.add(tfTailleX ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tfTailleY = new JLabel("taille en ordonnée :");
        this.add(tfTailleY ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.tailleX = new JTextField("100");
        this.add(tailleX ,gbc);
        //tailleX.getText()
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.tailleY = new JTextField("100");
        this.add(tailleY ,gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 1;
        //---------------------------------------------        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        this.butValid = new JButton("Valider");
        //this.butValid.addActionListener(new ValidParam(obj, Integer.valueOf(tailleX.getText()), Integer.valueOf(tailleY.getText())));
        this.add(butValid, gbc);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 2;
        
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tfStep = new JLabel("Nombre de tour :");
        this.add(tfStep ,gbc);
        this.tfStep.setVisible(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 2;
        //---------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.tfStepNumber = new JTextField("50");
        this.add(tfStepNumber ,gbc);
        this.tfStepNumber.setVisible(false);
        
        //---------------------------------------------
        gbc.weightx = 0;
        gbc.weighty = 3;
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        
        emptyCaserButton = new JRadioButton("Case \"Vide\"");
        jeunePousseCaserButton = new JRadioButton("Case \"Jeune pousse\"");
        jeunePousseCaserButton.setSelected(true);
        arbustreCaserButton = new JRadioButton("Case \"Arbustre\"");
        arbreCaserButton = new JRadioButton("Case \"Arbre\"");
        feuCaserButton = new JRadioButton("Case \"Feu\"");
        cendreCaserButton = new JRadioButton("Case \"Cendre\"");
        insecteCaserButton = new JRadioButton("Case \"Insecte\"");
        
        caseGroup = new ButtonGroup();
        caseGroup.add(emptyCaserButton);
        caseGroup.add(jeunePousseCaserButton);
        caseGroup.add(arbustreCaserButton);
        caseGroup.add(arbreCaserButton);
        caseGroup.add(feuCaserButton);
        caseGroup.add(cendreCaserButton);
        caseGroup.add(insecteCaserButton);
        
        radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(emptyCaserButton);
        radioPanel.add(jeunePousseCaserButton);
        radioPanel.add(arbustreCaserButton);
        radioPanel.add(arbreCaserButton);
        radioPanel.add(feuCaserButton);
        radioPanel.add(cendreCaserButton);
        radioPanel.add(insecteCaserButton);
        
        this.add(radioPanel, gbc);
        this.radioPanel.setVisible(false);
        
        //---------------------------------------------      
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.butGeneration = new JButton("Génération");
        //this.butGeneration.addActionListener(new ButGeneration(this.mainframe, this.tailleX.getText(), this.tailleY.getText()));
        this.add(butGeneration, gbc);
        this.butGeneration.setEnabled(false);
        
        //---------------------------------------------
        
        gbc.weightx = 0;
        gbc.weighty = 0;
        //---------------------------------------------        
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.butNext = new JButton("Tour suivant");
        //this.butGeneration.addActionListener(new ButGeneration(this.mainframe, this.tailleX.getText(), this.tailleY.getText()));
        this.add(butNext, gbc);
        this.butNext.setEnabled(false);
    }

    public JButton getButGeneration() {
        return butGeneration;
    }

    public JButton getButNext() {
        return butNext;
    }

    public JButton getButValid() {
        return butValid;
    }

    public MainFrame getMainframe() {
        return mainframe;
    }

    public JTextField getTailleX() {
        return tailleX;
    }

    public JTextField getTailleY() {
        return tailleY;
    }

    public JLabel getTfTailleX() {
        return tfTailleX;
    }

    public JLabel getTfTailleY() {
        return tfTailleY;
    }

    public JRadioButton getArbreCaserButton() {
        return arbreCaserButton;
    }

    public JRadioButton getArbustreCaserButton() {
        return arbustreCaserButton;
    }

    public ButtonGroup getCaseGroup() {
        return caseGroup;
    }

    public JRadioButton getCendreCaserButton() {
        return cendreCaserButton;
    }

    public JRadioButton getEmptyCaserButton() {
        return emptyCaserButton;
    }

    public JRadioButton getFeuCaserButton() {
        return feuCaserButton;
    }

    public JRadioButton getInsecteCaserButton() {
        return insecteCaserButton;
    }

    public JRadioButton getJeunePousseCaserButton() {
        return jeunePousseCaserButton;
    }

    public JPanel getRadioPanel() {
        return radioPanel;
    }

    public JLabel getTfStep() {
        return tfStep;
    }

    public JTextField getTfStepNumber() {
        return tfStepNumber;
    }
    
    
}
