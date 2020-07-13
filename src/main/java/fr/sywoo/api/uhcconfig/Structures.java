package fr.sywoo.api.uhcconfig;

public class Structures {

    public enum Stuff{
        DEFAULT(0),
        NORMAL(1),
        EPIC(2),
        INSANE(3);

        private int stuff;

        private Stuff(int stuff) {
            this.setStuff(stuff);
        }

        public int getStuff() {
            return stuff;
        }

        public void setStuff(int stuff) {
            this.stuff = stuff;
        }


    }


}