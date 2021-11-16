import java.util.List;

public interface GenericDAO<T, R> {

    public void adicionar(T model);

    public List<T> buscarTodos();

    public T buscarPorId(R id);
}
