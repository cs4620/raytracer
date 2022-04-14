public class PhongMaterial implements Material{
  private Vector3 color;

  public PhongMaterial(Vector3 color){
    this.color = color;
  }
  public Vector3 Shade(Vector3 fromDirection, Vector3 position, Vector3 normal, DirectionalLight directionalLight, Scene scene){
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

    var diffuse = this.color.scale(diffuseStrength);



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
