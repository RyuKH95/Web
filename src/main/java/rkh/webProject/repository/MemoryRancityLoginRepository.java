package rkh.webProject.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import rkh.webProject.domain.RUser;

public class MemoryRancityLoginRepository implements RancityRepository{

    private static Map<Long, RUser> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public RUser signIn(RUser rUser) {
        rUser.setNum(sequence++);
        store.put(rUser.getNum(), rUser);
        return rUser;
    }

    @Override
    public Optional<RUser> findByIdPw(String id, String pw) {
        return Optional.empty();
    }

    public void clearStore() {
        store.clear();
    }
}
