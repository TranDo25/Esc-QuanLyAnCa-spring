package com.esc.QuanLyAnCa.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageModel {
    private String devMsg;
    private String userMsg;
}
