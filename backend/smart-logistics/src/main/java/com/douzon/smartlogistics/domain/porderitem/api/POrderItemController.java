package com.douzon.smartlogistics.domain.porderitem.api;

import com.douzon.smartlogistics.domain.entity.POrderItem;
import com.douzon.smartlogistics.domain.porderitem.application.POrderItemService;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemInsertDto;
import com.douzon.smartlogistics.domain.porderitem.dto.POrderItemModifyDto;
import com.douzon.smartlogistics.global.common.response.CommonResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/porder-item")
public class POrderItemController {

    private final POrderItemService pOrderItemService;

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<String>> insert(@RequestBody @Valid POrderItemInsertDto pOrderItemInsertDto) {

        pOrderItemService.insert(pOrderItemInsertDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @PatchMapping("/modify")
    public ResponseEntity<CommonResponse<String>> modify(
        @RequestParam Long pOrderItemNo,
        @RequestBody @Valid POrderItemModifyDto pOrderItemModifyDto) {

        pOrderItemService.modify(pOrderItemNo, pOrderItemModifyDto);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }

    @GetMapping("/list")
    public ResponseEntity<CommonResponse<List<POrderItem>>> searchPOrderItemList(@RequestParam String pOrderCode) {

        List<POrderItem> pOrderItems = pOrderItemService.searchPOrderItemList(pOrderCode);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWith(pOrderItems));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CommonResponse<String>> delete(@RequestParam Long pOrderItemNo) {
        pOrderItemService.delete(pOrderItemNo);

        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(CommonResponse.successWithDefaultMessage());
    }
}