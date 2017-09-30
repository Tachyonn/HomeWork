package homeWork03;


public class TestVector3d {

    public static void main(String[] args) {
        Vector3d vector1 = new Vector3d(1, 1, 1);
        Vector3d vector2 = new Vector3d(1, 2, 2);
        Vector3d vector3 = new Vector3d(3, 3, 3);

        vector1.add(vector2);
        System.out.println("Vector1: " + vector1);

        vector3.add(vector2);
        System.out.println("Vector3: " + vector3);

        System.out.println("Scalar Mult: " + vector1.scalarMult(vector2));

        System.out.println("Vector Mult: " + vector1.vectorMult(vector2));
        System.out.println("Vector Mult: " + vector2.vectorMult(vector3));


    }
}
