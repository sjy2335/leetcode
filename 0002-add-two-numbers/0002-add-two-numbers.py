# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()
        curr = None
        over = 0

        while l1 is not None or l2 is not None:
            if curr == None:
                curr = result
            else:
                curr.next = ListNode()
                curr = curr.next

            curr.val = over
            if l1 != None:
                curr.val += l1.val
                l1 = l1.next
            if l2 != None:
                curr.val += l2.val
                l2 = l2.next

            over = curr.val // 10
            curr.val %= 10
        
        if over == 1:
            curr.next = ListNode(val=1)

        return result