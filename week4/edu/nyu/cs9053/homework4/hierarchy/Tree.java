package edu.nyu.cs9053.homework4.hierarchy;
import java.util.Random;

public class Tree{
    private Type typeInstance;
    private final String name;
    private final int age;

    public Tree(String name, int age,Type obj){
    this.name=name;
    this.age=age;
    this.typeInstance=obj;
    }

    public Type getType(){
        return typeInstance;
    }

    public String getClassName(){
        return (this.getClass().getSimpleName());
    }

    public boolean isEudicot(){
        return((getClassName().equals("Magnolia"))||(getClassName().equals("Nutmeg"))||(getClassName().equals("Avocado"))||(getClassName().equals("Birch"))||(getClassName().equals("Camphor")));
        }

    public boolean isSeedEnclosed(){
        return((getClassName().equals("Magnolia"))||(getClassName().equals("Nutmeg"))||(getClassName().equals("Avocado"))||(getClassName().equals("Birch"))||(getClassName().equals("Camphor")));

    }
}

//Conifer class
class Conifer extends Tree{
    private final String name;
    private final int age;

    public Conifer(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Conifer.class.isAssignableFrom(obj.getClass())) { //check on type information
            return false;
        }
        final Conifer other = (Conifer) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) { //chk on specific value
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }

}

//Magnolia
class Magnolia extends Tree{
    private final String name;
    private final int age;

    public Magnolia(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Magnolia.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Magnolia other = (Magnolia) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }

}

//Palm
class Palm extends Tree{
    private final String name;
    private final int age;

    public Palm(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Palm.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Palm other = (Palm) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Larch
class Larch extends Tree{
    private final String name;
    private final int age;

    public Larch(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Deciduous);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Larch.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Larch other = (Larch) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Cycad
class Cycad extends Tree{
    private final String name;
    private final int age;

    public Cycad(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Cycad.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Cycad other = (Cycad) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Redwood
class Redwood extends Tree{
    private final String name;
    private final int age;

    public Redwood(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Redwood.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Redwood other = (Redwood) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) { //chk on specific value
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Nutmeg
class Nutmeg extends Tree{
    private final String name;
    private final int age;

    public Nutmeg(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Nutmeg.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Nutmeg other = (Nutmeg) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 19;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Avocado
class Avocado extends Tree{
    private final String name;
    private final int age;

    public Avocado(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Avocado.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Avocado other = (Avocado) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 21;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Birch
class Birch extends Tree{
    private final String name;
    private final int age;

    public Birch(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Deciduous);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Birch.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Birch other = (Birch) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 27;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

//Camphor
class Camphor extends Tree{
    private final String name;
    private final int age;

    public Camphor(String tree_name, int tree_age){
            super(tree_name,tree_age,Type.Evergreen);
            this.name=tree_name;
            this.age=tree_age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Camphor.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Camphor other = (Camphor) obj;
        if ((this.name == null) ? (other.name != null) : (this.name != other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 29;
        hash = 53 * hash + (this.name != null ? (new Random().nextInt(10000000) + 1) : 0);
        hash = 53 * hash + this.age;
        return hash;
    }
}

enum Type{
    Evergreen, Deciduous;
}
