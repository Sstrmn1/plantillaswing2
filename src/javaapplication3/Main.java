package javaapplication3;

import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Main {

    private static NewJFrame frame;

    public static void main(String[] args) {
        // Configurar el aspecto de la interfaz Swing (LookAndFeel)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Crear y configurar el JFrame
        mostrarFramePrincipal();

        // Después de que la ventana principal esté visible, agrega la rama "Medicamentos" al JTree
        if (frame != null) {
            javax.swing.JTree jTree1 = frame.getJTree();
            if (jTree1 != null) {
                agregarRamaMedicamentos(jTree1);
            }
        }
    }

    private static void mostrarFramePrincipal() {
        // Crear una instancia de NewJFrame
        frame = new NewJFrame();

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Hacer la ventana visible
        frame.setVisible(true);
    }


    private static void agregarRamaMedicamentos(javax.swing.JTree jTree1) {
        // Obtén el modelo de datos del JTree
        DefaultTreeModel treeModel = (DefaultTreeModel) jTree1.getModel();

        // Crea un nuevo nodo para la rama "Medicamentos"
        DefaultMutableTreeNode medicamentosNode = new DefaultMutableTreeNode("Medicamentos");

        // Crea los nodos para "Antibióticos" y "No Antibióticos"
        DefaultMutableTreeNode antibioticosNode = new DefaultMutableTreeNode("Antibióticos");
        DefaultMutableTreeNode noAntibioticosNode = new DefaultMutableTreeNode("No Antibióticos");

        // Agrega los nodos "Antibióticos" y "No Antibióticos" como hijos de "Medicamentos"
        medicamentosNode.add(antibioticosNode);
        medicamentosNode.add(noAntibioticosNode);

        // Agrega los elementos "Amoxicilina" y "Penicilina" como hijos de "Antibióticos"
        DefaultMutableTreeNode amoxicilinaNode = new DefaultMutableTreeNode("Amoxicilina");
        DefaultMutableTreeNode penicilinaNode = new DefaultMutableTreeNode("Penicilina");
        antibioticosNode.add(amoxicilinaNode);
        antibioticosNode.add(penicilinaNode);

        // Agrega los elementos "Dexametasona" y "Diclofenaco" como hijos de "No Antibióticos"
        DefaultMutableTreeNode dexametasonaNode = new DefaultMutableTreeNode("Dexametasona");
        DefaultMutableTreeNode diclofenacoNode = new DefaultMutableTreeNode("Diclofenaco");
        noAntibioticosNode.add(dexametasonaNode);
        noAntibioticosNode.add(diclofenacoNode);

        // Agrega el nodo "Medicamentos" como hijo de la raíz del árbol (o cualquier otro nodo deseado)
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel.getRoot();
        rootNode.add(medicamentosNode);

        // Notifica al modelo de datos que se han realizado cambios
        treeModel.nodeStructureChanged(rootNode);

        // Expande la rama "Medicamentos" para que sea visible
//        jTree1.expandPath(new TreePath(medicamentosNode.getPath()));
    }

}
