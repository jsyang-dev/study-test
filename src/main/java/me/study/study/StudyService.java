package me.study.study;

import me.study.domain.Member;
import me.study.domain.Study;
import me.study.member.MemberService;

import java.util.Optional;

public class StudyService {

    private final MemberService memberService;

    private final StudyRepository repository;


    public StudyService(MemberService memberService, StudyRepository repository) {
        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        study.setOwner(member.orElseThrow(() -> new IllegalArgumentException("Member doesn't exist for id: '" + memberId + "'")));
        Study newStudy = repository.save(study);
        memberService.notify(newStudy);
        memberService.notify(member.get());
        return newStudy;
    }
}
