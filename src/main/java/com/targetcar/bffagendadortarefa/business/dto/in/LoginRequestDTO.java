package com.targetcar.bffagendadortarefa.business.dto.in;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDTO {

    private String email;
    private String senha;
}
