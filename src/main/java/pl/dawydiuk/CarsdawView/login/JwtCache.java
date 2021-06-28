package pl.dawydiuk.CarsdawView.login;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public enum JwtCache {

    JWT_CACHE;

    private volatile String jwt = null;
    private volatile LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(5);

    public String fetchJwt(Supplier<String> jwtSupplier) {
        if (jwt == null || isExpiredJwt()) {
            cacheJwt(jwtSupplier);
        }
        return jwt;
    }

    public String getJwt() {
        return jwt;
    }

    private boolean isExpiredJwt() {
        return LocalDateTime.now().isAfter(expirationTime);
    }

    private void cacheJwt(Supplier<String> jwtSupplier) {
        if (jwt == null || isExpiredJwt()) {
            jwt = jwtSupplier.get();
            expirationTime = LocalDateTime.now().plusMinutes(5);
        }
    }



}
