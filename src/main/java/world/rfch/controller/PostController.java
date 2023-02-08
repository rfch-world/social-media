package world.rfch.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.rfch.dto.request.PostRequestDTO;
import world.rfch.dto.response.PostResponseDto;
import world.rfch.dto.response.ResponseDto;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.service.impl.PostServiceImpl;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class PostController {

private final PostServiceImpl postServiceImpl;

@DeleteMapping("/delete/{userId}/{postId}")
   public ResponseEntity<Void> deleteById(@PathVariable Long userId,@PathVariable Long postId ){
   try {
       postServiceImpl.deleteLike(userId,postId);
       return ResponseEntity.status(HttpStatus.OK).build();
   }catch (Exception ex){
return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
   }
   }
@PostMapping("/add/{userid}/{postId}")
public ResponseEntity<Void> addLike(@PathVariable Long userId,@PathVariable Long postId){
try {
    postServiceImpl.addLike(userId, postId);
return ResponseEntity.status(HttpStatus.OK).build();
}catch (Exception ex){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
}
@PostMapping("/save")
public ResponseEntity<Void> save(@RequestBody PostRequestDTO postRequestDTO ){
try {
    postServiceImpl.save(postRequestDTO.toEntity());
return ResponseEntity.status(HttpStatus.CREATED).build();
}
catch (Exception ex){
   return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
}
@GetMapping("/all")
public ResponseEntity<List<PostResponseDto>> findAllByOrderByLikeCountDescDate(){
   List<PostEntity> postEntities=postServiceImpl.findAllByOrderByLikeCountDescDate();
   List<PostResponseDto> postResponseDtos=new ArrayList<>();
   for(PostEntity postEntiy:postEntities){
       PostResponseDto postResponseDto=new PostResponseDto();
       postResponseDto.setContent(postEntiy.getContent());
       postResponseDto.setDate(postEntiy.getDate());
       postResponseDto.setUsername(postEntiy.getUser().getUsername());
       List<String> list=new ArrayList<>();
       for (UserEntity user:postEntiy.getTaggedUserList()){
           list.add(user.getUsername());}
       postResponseDto.setTaggedUserIdList(list);
       postResponseDto.setStatus(postEntiy.getStatus());
       postResponseDto.setSource(postEntiy.getSource());

       postResponseDtos.add(postResponseDto);


   }
return ResponseEntity.ok(postResponseDtos);
}





@GetMapping("/{userId}/{postId}")

public ResponseEntity<Integer> isLiked(@PathVariable ("userId") Long userId, @PathVariable("postId") Long postId){
    return ResponseEntity.ok(postServiceImpl.isLiked(userId, postId));
}

@GetMapping("/{id}")
public ResponseEntity<ResponseDto> findById(@PathVariable Long id){
try {
    PostEntity postEntity=postServiceImpl.findById(id);
return ResponseEntity.ok(ResponseDto.builder().
                data(postEntity.getId().toString())
                        .httpStatus(HttpStatus.ACCEPTED).build());
}catch (Exception ex){
   return ResponseEntity.ok(ResponseDto.builder().data(ex.getMessage())
           .httpStatus(HttpStatus.BAD_REQUEST).build());
}

}

@GetMapping("/get/all/posts")
    public ResponseEntity<List<PostResponseDto>> findAll(){
    List<PostEntity> postEntities=postServiceImpl.findAll();
    List<PostResponseDto> postResponseDtos=new ArrayList<>();
    for (PostEntity postEntity:postEntities){
        PostResponseDto postResponseDto=new PostResponseDto();
        postResponseDto.setContent(postEntity.getContent());
        postResponseDto.setDate(postEntity.getDate());
        postResponseDto.setSource(postEntity.getSource());
        List<String> list=new ArrayList<>();
        for (UserEntity user: postEntity.getTaggedUserList()) {
            list.add(user.getUsername());}
        postResponseDto.setTaggedUserIdList(list);
        postResponseDto.setUsername(postEntity.getUser().getUsername());
    postResponseDto.setStatus(postEntity.getStatus());
    postResponseDtos.add(postResponseDto);
    }
return ResponseEntity.ok(postResponseDtos);
}
@DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<Void> deleteLike(@PathVariable ("userId") Long userId,@PathVariable("postId") Long postId){
    try {
        postServiceImpl.deleteLike(userId, postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }catch (Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
@GetMapping("/get/all")
public ResponseEntity<List<PostResponseDto>> findAllByStatusOrderByLikeCountDescDate(@RequestParam PostStatus postStatus){
List<PostEntity> postEntities=postServiceImpl.findAllByStatusOrderByLikeCountDescDate(postStatus);
List<PostResponseDto> postResponseDtos=new ArrayList<>();
for(PostEntity postEntity:postEntities){
    PostResponseDto postResponseDto=new PostResponseDto();
    postResponseDto.setStatus(postEntity.getStatus());
    postResponseDto.setDate(postEntity.getDate());
    postResponseDto.setSource(postEntity.getSource());
postResponseDto.setUsername(postEntity.getUser().getUsername());
postResponseDto.setContent(postEntity.getContent());
List<String> list=new ArrayList<>();
for (UserEntity user: postEntity.getTaggedUserList()){
    list.add(user.getUsername());
}
postResponseDto.setTaggedUserIdList(list);
postResponseDtos.add(postResponseDto);
}
return ResponseEntity.ok(postResponseDtos);
}
}
