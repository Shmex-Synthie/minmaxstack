public class MinMaxStackDemo {

    static void estado(MinMaxStack s, String operacao) {
        System.out.printf("%-30s | pilha: %-35s | min=%-4s | max=%s%n",
            operacao,
            s.isEmpty() ? "(vazia)" : s.toString(),
            s.isEmpty() ? "-" : s.min(),
            s.isEmpty() ? "-" : s.max());
    }

    public static void main(String[] args) {

        MinMaxStack s = new MinMaxStack();

        System.out.println("=".repeat(100));
        System.out.println("  DEMONSTRAÇÃO DA MinMaxStack — operações push / pop / min / max");
        System.out.println("=".repeat(100));
        System.out.printf("%-30s | %-37s | %-8s | %s%n",
                "Operação", "Estado da pilha (topo→base)", "min", "max");
        System.out.println("-".repeat(100));

        // Série 1: inserções crescentes
        s.push(10); estado(s, "push(10)");
        s.push(20); estado(s, "push(20)");
        s.push(30); estado(s, "push(30)");

        // Série 2: inserção de um novo mínimo
        s.push(5);  estado(s, "push(5)  ← novo mínimo");

        // Série 3: inserção de um novo máximo
        s.push(50); estado(s, "push(50) ← novo máximo");

        // Série 4: valor duplicado do mínimo atual
        s.push(5);  estado(s, "push(5)  ← duplicata do mínimo");

        // Série 5: valor duplicado do máximo atual
        s.push(50); estado(s, "push(50) ← duplicata do máximo");

        System.out.println("-".repeat(100));

        // Remoções: verificar se min/max se atualizam corretamente
        System.out.println("  Iniciando remoções...");
        System.out.println("-".repeat(100));

        int v = s.pop(); estado(s, "pop() → " + v); 
        v     = s.pop(); estado(s, "pop() → " + v);   
        v     = s.pop(); estado(s, "pop() → " + v); 
        v     = s.pop(); estado(s, "pop() → " + v);  
        v     = s.pop(); estado(s, "pop() → " + v);   
        v     = s.pop(); estado(s, "pop() → " + v);  
        v     = s.pop(); estado(s, "pop() → " + v);  

        System.out.println("=".repeat(100));

        // Série 6: negativos e zero
        System.out.println("  Série com negativos e zero:");
        System.out.println("-".repeat(100));
        s.push(0);   estado(s, "push(0)");
        s.push(-10); estado(s, "push(-10) ← mínimo negativo");
        s.push(7);   estado(s, "push(7)");
        s.push(-10); estado(s, "push(-10) ← duplicata negativa");
        s.push(100); estado(s, "push(100) ← novo máximo");
        v = s.pop(); estado(s, "pop() → " + v);
        v = s.pop(); estado(s, "pop() → " + v);
        v = s.pop(); estado(s, "pop() → " + v);  
        v = s.pop(); estado(s, "pop() → " + v); 
        v = s.pop(); estado(s, "pop() → " + v);

        System.out.println("=".repeat(100));
        System.out.println("  Fim da demonstração.");
    }
}
