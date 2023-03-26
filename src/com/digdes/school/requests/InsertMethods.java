package com.digdes.school.requests;

public class InsertMethods {

    public String getString(String request) {
        String lastName = null;
        int lastNameIndex = request.lastIndexOf("lastName");
        if (lastNameIndex > 0) {
            StringBuilder sb = new StringBuilder(request);
            String lastNameChanged = sb.delete(0, lastNameIndex).toString();
            lastNameChanged = lastNameChanged.replace("lastName'='", "");
            lastNameChanged = lastNameChanged.replace("lastName'!='", "");
            lastNameChanged = lastNameChanged.replace("lastName'like'", "");
            lastNameChanged = lastNameChanged.replace("lastName'ilike'", "");
            lastNameChanged = lastNameChanged.substring(0, lastNameChanged.indexOf("'"));
            lastName = lastNameChanged;
        }
        return lastName;
    }


    public Long getLong(String request, String type) {
        Long number = null;
        int idIndex = request.lastIndexOf(type);
        if (idIndex > 0) {
            StringBuilder sb = new StringBuilder(request);
            String numberChanged = sb.delete(0, idIndex).toString();
            numberChanged = numberChanged.replace(type + "'=", "");
            numberChanged = numberChanged.replace(type + "'!=", "");
            numberChanged = numberChanged.replace(type + "'>=", "");
            numberChanged = numberChanged.replace(type + "'<=", "");
            numberChanged = numberChanged.replace(type + "'>", "");
            numberChanged = numberChanged.replace(type + "'<", "");
            if (numberChanged.contains("'")) {
                if (numberChanged.contains("OR")) {
                    numberChanged = numberChanged.substring(0, numberChanged.indexOf("OR"));
                } else {
                    numberChanged = numberChanged.substring(0, numberChanged.indexOf(","));
                }
            }

            number = Long.parseLong(numberChanged);
        }
        return number;
    }

    public Double getDouble(String request, String type) {
        Double number = null;
        int idIndex = request.lastIndexOf(type);
        if (idIndex > 0) {
            StringBuilder sb = new StringBuilder(request);
            String numberChanged = sb.delete(0, idIndex).toString();
            numberChanged = numberChanged.replace(type + "'=", "");
            numberChanged = numberChanged.replace(type + "'!=", "");
            numberChanged = numberChanged.replace(type + "'>=", "");
            numberChanged = numberChanged.replace(type + "'<=", "");
            numberChanged = numberChanged.replace(type + "'>", "");
            numberChanged = numberChanged.replace(type + "'<", "");
            if (numberChanged.contains("'")) {
                if (numberChanged.contains("OR")) {
                    numberChanged = numberChanged.substring(0, numberChanged.indexOf("OR"));
                } else {
                    numberChanged = numberChanged.substring(0, numberChanged.indexOf(","));
                }
            }
            number = Double.parseDouble(numberChanged);
        }
        return number;
    }

    public boolean getActive(String request) throws Exception {

        String activeString = null;
        Boolean active = null;
        int activeIndex = request.lastIndexOf("active");

        if (activeIndex > 0) {
            StringBuilder sb = new StringBuilder(request);
            String activeChanged = sb.delete(0, activeIndex).toString();
            activeChanged = activeChanged.replace("active'=", "");
            if (activeChanged.contains("'")) {
                activeChanged = activeChanged.substring(0, activeChanged.indexOf("'"));
            }
            activeString = activeChanged;
        }

        if (activeString != null) {
            active = switch (activeString.replace(",", "")) {
                case ("true") -> true;
                case ("false") -> false;
                default -> throw new Exception("Такой фунцкии пока нет");
            };
        }
        return Boolean.TRUE.equals(active);
    }

}
