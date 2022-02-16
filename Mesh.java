import java.util.ArrayList;
import java.util.List;

public class Mesh {

  public List<Triangle> triangles = new ArrayList<>();

  public Mesh(List<Triangle> triangles){
    triangles.addAll(triangles);
  }

  public void addTriangle(Triangle toAdd){
    this.triangles.add(toAdd);
  }

  public List<Triangle> getTriangles(){
    return triangles;
  }

  public Triangle getTriangle(int index){
    return this.triangles.get(index);
  }

  public void replaceTriangle(int index, Triangle triangle){
    triangles.set(index, triangle);

  }
  
}
