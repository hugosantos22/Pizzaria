package dados.pizzaria;

import java.util.ArrayList;

public interface DaoInterface <T>
{
    public int criar(T o);
    public ArrayList<T> buscar(T o);
    public int atualizar(T o);
    public int apagar(T o);
}
