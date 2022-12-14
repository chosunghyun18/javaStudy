package hackathon.nomadworker.service;



import hackathon.nomadworker.domain.Feed;
import hackathon.nomadworker.domain.User;
import hackathon.nomadworker.domain.User_Reply;
import hackathon.nomadworker.repository.FeedRepository;
import hackathon.nomadworker.repository.UserReplyRepository;
import hackathon.nomadworker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserReplyService {
    private final UserReplyRepository userReplyRepository;
    private final UserRepository userRepository;
    private final FeedRepository feedRepository;

    @Transactional
    public User_Reply newReply(String reply_content, long u_id, long f_id, LocalDateTime localDateTime)
    {   User user = userRepository.findOne(u_id);
        Feed feed = feedRepository.findOne(f_id);
        return userReplyRepository.post(reply_content, user , feed,localDateTime);
    }


    @Transactional
    public void deleteByReplyId(Long r_id){userReplyRepository.delete(r_id);}

    @Transactional(readOnly = true)
    public List<User_Reply> findRepliesByFeedId(Long f_id)
    {
        return userReplyRepository.findAllByFeedid(f_id);
    }

    @Transactional(readOnly = true)
    public int findRepliesCountByFeedId(Long f_id)
    {
        return userReplyRepository.findAllByFeedid(f_id).size();
    }
    @Transactional(readOnly = true)
    public User_Reply findOneByReplyId(Long r_id)
    {
       return  userReplyRepository.findOne(r_id);
    }



}
