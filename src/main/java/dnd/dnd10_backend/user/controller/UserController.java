package dnd.dnd10_backend.user.controller;

import dnd.dnd10_backend.common.domain.CommonResponse;
import dnd.dnd10_backend.common.domain.SingleResponse;
import dnd.dnd10_backend.common.domain.enums.CodeStatus;
import dnd.dnd10_backend.common.service.ResponseService;
import dnd.dnd10_backend.config.jwt.JwtProperties;
import dnd.dnd10_backend.user.domain.User;
import dnd.dnd10_backend.user.dto.request.UserRequestDto;
import dnd.dnd10_backend.user.dto.request.UserSaveRequestDto;
import dnd.dnd10_backend.user.dto.response.UserResponseDto;
import dnd.dnd10_backend.user.oauth.domain.OauthToken;
import dnd.dnd10_backend.user.service.TokenService;
import dnd.dnd10_backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 패키지명 dnd.dnd10_backend.user.controller
 * 클래스명 UserController
 * 클래스설명
 * 작성일 2023-01-18
 *
 * @author 원지윤
 * @version 1.0
 * [수정내용]
 * 예시) [2022-09-17] 주석추가 - 원지윤
 * [2023-01-31] 프론트에 토큰 관련 헤더 노출 - 원지윤
 * [2023-02-02] 사용자 정보 조회, 등록 , 수정 api 추가 - 원지윤
 * [2023-02-02] 토큰 관련 컨트롤러 분리 - 원지윤
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseService responseService;

    /**
     * 사용자 정보 조회
     * @param requestDto
     * @return
     */
    @GetMapping("/user")
    public ResponseEntity getUser(@RequestBody UserRequestDto requestDto){
        UserResponseDto userResponseDto = userService.getUserByEmail(requestDto);
        SingleResponse<UserResponseDto> response = responseService.getResponse(userResponseDto, CodeStatus.SUCCESS_SEARCHED_USER);
        return ResponseEntity.ok().body(response);
    }

    /**
     * 사용자 등록
     * @param requestDto
     * @return
     */
    @PostMapping("/user/signup")
    public ResponseEntity signupUser(@RequestBody UserSaveRequestDto requestDto){
        UserResponseDto userResponseDto = userService.saveUser(requestDto);
        SingleResponse<UserResponseDto> response = responseService.getResponse(userResponseDto, CodeStatus.SUCCESS_CREATED_USER);
        return ResponseEntity.ok().body(response);
    }

    /**
     * 사용자 정보 업데이트
     * @param requestDto
     * @return
     */
    @PutMapping("/user/update")
    public ResponseEntity updateUser(@RequestBody UserSaveRequestDto requestDto){
        UserResponseDto userResponseDto = userService.saveUser(requestDto);
        SingleResponse<UserResponseDto> response = responseService.getResponse(userResponseDto, CodeStatus.SUCCESS_UPDATED_USER);
        return ResponseEntity.ok().body(response);
    }

}
