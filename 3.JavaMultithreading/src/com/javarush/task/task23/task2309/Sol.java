package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/*
Анонимность иногда так приятна!
*/

public class Sol {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers() {
        AbstractDbSelectExecutor<User> res = new AbstractDbSelectExecutor() {
            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }
        };
        return res.execute();
    }

    public List<Location> getLocations() {
        AbstractDbSelectExecutor<Location> res = new AbstractDbSelectExecutor() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        return res.execute();
    }

    public List<Server> getServers() {
        AbstractDbSelectExecutor<Server> res = new AbstractDbSelectExecutor() {

            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        };
        return res.execute();
    }

    public List<Subject> getSubjects() {
        AbstractDbSelectExecutor<Subject> res = new AbstractDbSelectExecutor() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        };
        return res.execute();
    }

    public List<Subscription> getSubScriptions() {
        AbstractDbSelectExecutor<Subscription> res = new AbstractDbSelectExecutor() {
            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        };
        return res.execute();
    }
}
