package world.rfch.service;

import world.rfch.jpa.entity.Authority;

public interface AuthService {
    Authority getByAuthority(String authority);
}
