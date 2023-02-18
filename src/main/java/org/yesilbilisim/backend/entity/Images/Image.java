package org.yesilbilisim.backend.entity.Images;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String folder;
    private String filename;
}
