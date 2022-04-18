public class CheckeredPhong implements Material{
  private Vector3 color;

  public CheckeredPhong(Vector3 color){
    this.color = color;
  }
  public Vector3 Shade(Vector3 fromDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight, Scene scene, int remainingBounces){
    //Fire a shadow ray
    var lightDirection = directionalLight.directionToLight;
    var shadowRay = scene.shootRay(
      new Ray(
        position.plus(lightDirection.scale(.1f)), 
        directionalLight.directionToLight)
        );
    var inShadow = false;
    if(shadowRay  != null){
      inShadow = true;
    }
    
    //Flip normals for double-sided triangles
    if(normal.dot(fromDirection) < 0)
    {
      normal = normal.scale(-1);
    }
    
    var ambient = new Vector3(.1f, .1f, .1f);

    var diffuseStrength = normal.normalize().dot(directionalLight.directionToLight.normalize());
    diffuseStrength = Math.max(0, diffuseStrength);


    var currentColor = this.color;
    int fx = (int)(position.x -100 + .5);
    var fy = (int)(position.y + .5);
    var fz = (int)(position.z + .5);

    if((fx + fy + fz) % 2 == 0){
      currentColor = Vector3.Zero;
    }
    var diffuse = currentColor.scale(diffuseStrength);



    //Find the reflection of the light with regards to the normal
    //compare that to the from direction


    var reflection = directionalLight.directionToLight.reflect(normal);
    var specularStrength = Math.max(0, reflection.dot(fromDirection));
    specularStrength = (float)Math.pow(specularStrength, 4);


    var specular = new Vector3(1f, 1f, 1f).scale(specularStrength);

    Vector3 finalColor;
    if(inShadow){
      finalColor =  ambient;
    }
    else{
      finalColor =  ambient.plus(diffuse).plus(specular);
    }
    finalColor = finalColor.clamp(0, 1);

    return finalColor;
    // return this.color;
  }

  
  
}
