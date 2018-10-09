public class Aresta implements Comparable<Aresta> {

    int origem;
    int destino;
    int peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Aresta t) {
        if (this.peso > t.peso) {
            return 1;
        } else {
            return -1;
        }

    }

}
