package enums;
        public enum Priority {
                low, medium, high;

                public static boolean isMoreImportant(Priority a, Priority b) {
                        if (a.equals(high) && (!b.equals(high))) return true;
                        if (a.equals(medium) && (b.equals(low))) return true;
return false;
                }

        };


