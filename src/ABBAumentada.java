import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int size;

    public TreeNode(int val) {
        this.val = val;
        this.size = 1;
    }
}

public class ABBAumentada {
    private TreeNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) {
            return null;
        }

        if (val < node.val) {
            node.left = remove(node.left, val);
        } else if (val > node.val) {
            node.right = remove(node.right, val);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.val = minValue(node.right);
            node.right = remove(node.right, node.val);
        }

        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private int minValue(TreeNode node) {
        int minValue = node.val;
        while (node.left != null) {
            minValue = node.left.val;
            node = node.left;
        }
        return minValue;
    }

    public int enesimoElemento(int n) {
        return enesimoElemento(root, n);
    }

    private int enesimoElemento(TreeNode node, int n) {
        if (node == null) {
            return -1;
        }

        int leftSize = size(node.left) + 1;

        if (n == leftSize) {
            return node.val;
        } else if (n < leftSize) {
            return enesimoElemento(node.left, n);
        } else {
            return enesimoElemento(node.right, n - leftSize);
        }
    }

    public int posicao(int x) {
        int[] count = { 1 };
        return posicao(root, x, count);
    }

    private int posicao(TreeNode node, int x, int[] count) {
        if (node == null) {
            return -1;
        }

        int leftPos = posicao(node.left, x, count);

        if (leftPos != -1) {
            return leftPos;
        }

        if (node.val == x) {
            return count[0] + size(node.left);
        }

        count[0]++;
        return posicao(node.right, x, count);
    }

    public int mediana() {
        int size = size(root);
        if (size % 2 == 1) {
            return enesimoElemento((size + 1) / 2);
        } else {
            int leftMedian = enesimoElemento(size / 2);
            int rightMedian = enesimoElemento(size / 2 + 1);
            return Math.min(leftMedian, rightMedian);
        }
    }

    public double media(TreeNode node) {
        int sum = sum(node);
        int count = size(node);
        return (double) sum / count;
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    private int size(TreeNode node) {
        return (node == null) ? 0 : node.size;
    }

    public boolean ehCheia() {
        return ehCheia(root);
    }

    private boolean ehCheia(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return ehCheia(node.left) && ehCheia(node.right);
        }

        return false;
    }

    public boolean ehCompleta() {
        int index = 0;
        return ehCompleta(root, index, size(root));
    }

    private boolean ehCompleta(TreeNode node, int index, int size) {
        if (node == null) {
            return true;
        }

        if (index >= size) {
            return false;
        }

        return ehCompleta(node.left, 2 * index + 1, size) && ehCompleta(node.right, 2 * index + 2, size);
    }

    public String preOrdem() {
        StringBuilder result = new StringBuilder();
        preOrdem(root, result);
        return result.toString();
    }

    private void preOrdem(TreeNode node, StringBuilder result) {
        if (node != null) {
            result.append(node.val).append(" ");
            preOrdem(node.left, result);
            preOrdem(node.right, result);
        }
    }

    public void imprimeArvore(int s) {
        if (s == 1) {
            imprimeArvoreFormato1(root);
        } else if (s == 2) {
            imprimeArvoreFormato2(root, 0);
        }
    }

    private void imprimeArvoreFormato1(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            imprimeArvoreFormato1(node.left);
            imprimeArvoreFormato1(node.right);
        }
    }

    private void imprimeArvoreFormato2(TreeNode node, int depth) {
        if (node != null) {
            imprimeArvoreFormato2(node.right, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("    ");
            }
            System.out.println(node.val);
            imprimeArvoreFormato2(node.left, depth + 1);
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java ABBAumentada arquivo_entrada.txt arquivo_comandos.txt");
            return;
        }

        String arquivoEntrada = args[0];
        String arquivoComandos = args[1];

        ABBAumentada abb = new ABBAumentada();

        // Ler o arquivo de entrada e construir a ABB
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
            String line;
            while ((line = reader.readLine()) != null) {
                int value = Integer.parseInt(line);
                abb.insert(value);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Ler o arquivo de comandos e executar as operações
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoComandos));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String comando = parts[0];
                if (comando.equals("IMPRIMA")) {
                    int formato = Integer.parseInt(parts[1]);
                    abb.imprimeArvore(formato);
                } else if (comando.equals("MEDIANA")) {
                    System.out.println("Mediana: " + abb.mediana());
                } else if (comando.equals("ENESIMO")) {
                    int n = Integer.parseInt(parts[1]);
                    System.out.println("N-ésimo elemento: " + abb.enesimoElemento(n));
                } else if (comando.equals("POSICAO")) {
                    int x = Integer.parseInt(parts[1]);
                    System.out.println("Posição do elemento: " + abb.posicao(x));
                } else if (comando.equals("CHEIA")) {
                    System.out.println("É uma árvore cheia? " + abb.ehCheia());
                } else if (comando.equals("COMPLETA")) {
                    System.out.println("É uma árvore completa? " + abb.ehCompleta());
                } else if (comando.equals("REMOVA")) {
                    int valorRemover = Integer.parseInt(parts[1]);
                    abb.remove(valorRemover);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

