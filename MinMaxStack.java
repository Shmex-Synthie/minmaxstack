import java.util.EmptyStackException;
import java.util.Scanner;


public class MinMaxStack {

    private static class Node {
        final int value;
        final int currentMin;
        final int currentMax;
        Node below;

        Node(int value, int currentMin, int currentMax, Node below) {
            this.value      = value;
            this.currentMin = currentMin;
            this.currentMax = currentMax;
            this.below      = below;
        }
    }

    private Node top;
    private int  size;

    public void push(int value) {
        int newMin = (top == null) ? value : Math.min(value, top.currentMin);
        int newMax = (top == null) ? value : Math.max(value, top.currentMax);
        top = new Node(value, newMin, newMax, top);
        size++;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int val = top.value;
        top = top.below;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public int min() {
        if (isEmpty()) throw new EmptyStackException();
        return top.currentMin;
    }

    public int max() {
        if (isEmpty()) throw new EmptyStackException();
        return top.currentMax;
    }

    public boolean isEmpty() { return top == null; }
    public int     size()    { return size; }

    @Override
    public String toString() {
        if (isEmpty()) return "(vazia)";
        StringBuilder sb = new StringBuilder("[");
        Node cur = top;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.below != null) sb.append(", ");
            cur = cur.below;
        }
        return sb.append("] (topo->base)").toString();
    }

    private static void estado(MinMaxStack s) {
        System.out.println();
        linha('-');
        System.out.println("  Pilha  : " + s);
        System.out.println("  Tamanho: " + s.size());
        if (!s.isEmpty()) {
            System.out.println("  Topo   : " + s.peek());
            System.out.println("  min()  : " + s.min());
            System.out.println("  max()  : " + s.max());
        }
        linha('-');
    }

    private static void menu() {
        System.out.println();
        System.out.println("  Escolha uma opcao:");
        System.out.println("  [1] push  - inserir valor no topo");
        System.out.println("  [2] pop   - remover valor do topo");
        System.out.println("  [3] peek  - ver valor do topo (sem remover)");
        System.out.println("  [4] min   - ver menor valor da pilha");
        System.out.println("  [5] max   - ver maior valor da pilha");
        System.out.println("  [6] exibir estado completo da pilha");
        System.out.println("  [0] sair");
        System.out.print("  > ");
    }
    public static void main(String[] args) {
        MinMaxStack s = new MinMaxStack();
        Scanner sc = new Scanner(System.in);

        linha('=');
        System.out.println("  MinMaxStack - Pilha com min() e max() em O(1)");
        linha('=');
        estado(s);

        boolean rodando = true;
        while (rodando) {
            menu();

            String entrada = sc.nextLine().trim();

            switch (entrada) {
                case "1": {
                    System.out.print("  Valor para inserir: ");
                    String valorStr = sc.nextLine().trim();
                    try {
                        int valor = Integer.parseInt(valorStr);
                        s.push(valor);
                        System.out.println("  >> push(" + valor + ") realizado.");
                        estado(s);
                    } catch (NumberFormatException e) {
                        System.out.println("  [ERRO] Valor invalido. Digite um numero inteiro.");
                    }
                    break;
                }
                case "2": {
                    try {
                        int removido = s.pop();
                        System.out.println("  >> pop() removeu: " + removido);
                        estado(s);
                    } catch (EmptyStackException e) {
                        System.out.println("  [ERRO] A pilha esta vazia.");
                    }
                    break;
                }
                case "3": {
                    try {
                        System.out.println("  >> peek() = " + s.peek());
                    } catch (EmptyStackException e) {
                        System.out.println("  [ERRO] A pilha esta vazia.");
                    }
                    break;
                }
                case "4": {
                    try {
                        System.out.println("  >> min() = " + s.min());
                    } catch (EmptyStackException e) {
                        System.out.println("  [ERRO] A pilha esta vazia.");
                    }
                    break;
                }
                case "5": {
                    try {
                        System.out.println("  >> max() = " + s.max());
                    } catch (EmptyStackException e) {
                        System.out.println("  [ERRO] A pilha esta vazia.");
                    }
                    break;
                }
                case "6": {
                    estado(s);
                    break;
                }
                case "0": {
                    rodando = false;
                    System.out.println();
                    linha('=');
                    System.out.println("  Encerrando. Ate logo!");
                    linha('=');
                    break;
                }
                default: {
                    System.out.println("  [ERRO] Opcao invalida. Tente novamente.");
                }
            }
        }

        sc.close();
    }

    private static void linha(char c) {
        String seg = "" + c;
        System.out.println(seg.repeat(50));
    }
}